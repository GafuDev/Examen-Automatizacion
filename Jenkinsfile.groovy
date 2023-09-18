pipeline {
    agent any // Ejecuta el pipeline en cualquier agente disponible

    stages {
        stage('Preparación del Proyecto') {
            steps {
                bat 'echo Realizando preparación del proyecto...'
                // Utiliza comandos de Windows aquí
            }
        }

        stage('Construcción del Proyecto') {
            steps {
                bat 'echo Realizando construcción del proyecto...'
                // Utiliza comandos de Windows para la construcción, por ejemplo: mvn clean install
            }
        }

        stage('Pruebas del Proyecto') {
            steps {
                bat 'echo Realizando pruebas del proyecto...'
                // Utiliza comandos de prueba y guarda los resultados en un archivo XML
                // Ejemplo: junit 'ruta\\al\\archivo.xml'
            }
        }
    }

    post {
        always {
            // Esta etapa se ejecutará siempre, incluso si alguna de las etapas anteriores falla
            archiveArtifacts artifacts: '**\\target\\*.war', allowEmptyArchive: true
            // Aquí se archiva el artefacto generado después de la compilación (ajusta la ruta según tu proyecto)
        }
    }
}
