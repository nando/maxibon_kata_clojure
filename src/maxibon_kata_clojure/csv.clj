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
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [map-key value]]
                   (assoc row-map map-key (convert map-key value)))
                 {}
                 (map vector developer-keys unmapped-row)))
       rows))

(defn csv2hash-map
  [ filename ]
  (mapify
    (parse
      (slurp filename))))

(def memoized-csv2hash-map (memoize csv2hash-map))

(defn load_developers
  "Returns a vector with developer team names (Karumies if team_name not present!!)"
  ([]
     (load_developers "Karumies"))
  ([ team_name ]
     (memoized-csv2hash-map (str team_name ".csv"))))
