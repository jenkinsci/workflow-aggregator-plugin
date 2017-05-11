def call(args) {
    ansiColor('xterm') {
        sh "${tool 'Maven 3.x'}/bin/mvn ${args}"
    }
}
