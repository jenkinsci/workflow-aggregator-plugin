def call(args) {
    sh "${tool 'Maven 3.x'}/bin/mvn ${args}"
}
