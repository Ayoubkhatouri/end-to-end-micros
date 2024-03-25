pipeline {
  agent any
  stages {
    stage('check mvn') {
      steps {
        sh 'mvn --version'
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