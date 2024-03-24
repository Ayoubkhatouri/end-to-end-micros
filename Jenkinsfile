pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        sh 'ls -la'
        git(url: 'https://github.com/Ayoubkhatouri/end-to-end-micros', branch: 'master')
      }
    }

  }
}