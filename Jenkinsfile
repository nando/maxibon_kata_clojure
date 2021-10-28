pipeline {
    agent {
        docker { image 'clojure:latest' }
    }

    stages {
        stage('Build') {
            steps {
                git url: 'https://github.com/nando/maxibon_kata_clojure.git ', branch: 'jenkins'

                sh "lein test"
            }
        }
    }
}
