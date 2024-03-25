pipeline {
  agent any
  tools {
    maven '3.9.6'
  }
  stages {
    stage('check mvn') {
      steps {
        sh 'mvn -version'
      }
    }

    stage('Checkout Code') {
      steps {
        sh 'ls -la'
        git(url: 'https://github.com/Ayoubkhatouri/end-to-end-micros', branch: 'master')
      }
    }

      
        stage('Logs') {
          steps {
            sh 'ls -la'
          }
        }

        stage('RunTests') {
          steps {
            sh 'cd customer-service && mvn test'
          }
    }

  }

}
