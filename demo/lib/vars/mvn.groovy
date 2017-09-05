def call(args) {
    configFileProvider([configFile(fileId: 'jenkins-mirror', variable: 'SETTINGS')]) {
        ansiColor('xterm') {
            sh "${tool 'Maven 3.x'}/bin/mvn -s \$SETTINGS ${args}"
        }
    }
}
