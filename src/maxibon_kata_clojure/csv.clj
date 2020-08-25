(ns maxibon-kata-clojure.csv)

(def developer-keys [:name :grabs])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :grabs str->int})

(defn convert
  [map-key value]
  ((get conversions map-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :grabs 10}"
  [team_name rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [map-key value]]
                   (assoc row-map map-key (convert map-key value)))
                 { :team team_name }
                 (map vector developer-keys unmapped-row)))
       rows))

(defn csv2hash-map
  [ team_name ]
  (mapify
    team_name
    (parse
      (slurp (str "./data/" team_name ".csv")))))

(defn load_developers
  "Returns a vector with developer team names (Karumies if team_name not present!!)"
  ([]
     (load_developers "Karumies"))
  ([ team_name ]
     (csv2hash-map team_name))
  ([ team_name & other_teams]
     (concat (csv2hash-map team_name)
             (apply load_developers other_teams))))

(def memoized-developers (memoize load_developers))
