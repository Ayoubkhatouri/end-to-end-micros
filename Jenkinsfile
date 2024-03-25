pipeline {
  agent any
  tools {
    maven '3.9.6'
  }
  stages {
    stage('check man') {
      steps {
        sh 'mvn --version'
      }
    }

  }
}