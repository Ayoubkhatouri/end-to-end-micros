pipeline {
  agent any
  stages {
    stage('check mvn') {
      parallel {
        stage('check mvn') {
          steps {
            sh 'mvn --version'
          }
        }

        stage('checkout code ') {
          steps {
            git(url: 'https://github.com/Ayoubkhatouri/end-to-end-micros', branch: 'master')
          }
        }

      }
    }

    stage('runTests') {
      steps {
        sh 'cd customer-service && mvn test'
      }
    }

  }
  tools {
    maven '3.9.6'
  }
}