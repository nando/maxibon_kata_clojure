pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git url: 'https://github.com/nando/maxibon_kata_clojure.git ', branch: 'main'

                sh "lein test"
            }
        }
    }
}
