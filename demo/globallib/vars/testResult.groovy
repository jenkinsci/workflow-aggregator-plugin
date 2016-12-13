@NonCPS def call(build) {
    def metadata = build.rawBuild.getAction(hudson.tasks.test.AbstractTestResultAction)
    def result = [passed: [], failed: [], skipped: []]
    if (metadata != null) {
        def parse = {list -> list.collect {it.fullDisplayName}}
        result.passed = parse(metadata.passedTests)
        result.failed = parse(metadata.failedTests)
        result.skipped = parse(metadata.skippedTests)
    }
    result
}
