pipeline {
    agent any

    tools {
        maven 'maven3.8.4'
    }

    stages {

        stage('Build') {
            steps {
                git branch: 'openshift-aws',
                    url: 'https://github.com/piyushgarg362-commits/BookStore.git'

                script {
                    def pom = readMavenPom file: 'pom.xml'
                    version = pom.version

                    echo "Building BookStore version: ${version}"
                }

                sh "${mvnCmd} clean package -DskipTests=true"
            }
        }

        stage('Deploy') {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject(env.DEV_PROJECT) {

                            sh "rm -rf ocp"
                            sh "mkdir -p ocp/deployments"

                            sh "cp target/bookstore-*.jar ocp/deployments/"

                            openshift.selector(
                                "bc",
                                "bookstore"
                            ).startBuild(
                                "--from-dir=./ocp",
                                "--follow",
                                "--wait=true"
                            )

                            openshift.selector(
                                "dc",
                                "bookstore"
                            ).rollout().latest()

                            echo "BookStore ${version} deployed successfully."
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Build and deployment completed successfully!"
        }

        failure {
            echo "Build or deployment failed!"
        }
    }
}
```
