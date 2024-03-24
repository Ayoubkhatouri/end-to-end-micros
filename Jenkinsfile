pipeline {
  agent any
  stages {
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

  }
}