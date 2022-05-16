# Jenkins Pipeline Plugin
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/workflow-aggregator.svg)](https://plugins.jenkins.io/workflow-aggregator)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/workflow-aggregator.svg?color=blue)](https://plugins.jenkins.io/workflow-aggregator)

This plugin and its dependencies form a suite of plugins that lets you orchestrate automation, simple or
complex. See [the Jenkins Pipeline documentation](https://jenkins.io/doc/book/pipeline/) for more details.  
Documentation on the Jenkins site:

-   [How do I start with Pipeline?](https://jenkins.io/doc/pipeline/tour/hello-world/)
-   [Pipeline Syntax Reference](https://jenkins.io/doc/book/pipeline/syntax/)
-   [Pipeline Steps Reference](https://jenkins.io/doc/pipeline/steps)
-   [Extending Pipeline with SharedLibraries](https://jenkins.io/doc/book/pipeline/shared-libraries/)

Other information about Pipeline is [available in
GitHub](https://github.com/jenkinsci/pipeline-plugin). Quick links:

-   [Developing plugins for
    Pipeline](https://github.com/jenkinsci/pipeline-plugin/blob/master/DEVGUIDE.md)
-   [Pipeline CPS
    Engine](https://github.com/jenkinsci/workflow-cps-plugin)
-   [SCM
    step](https://github.com/jenkinsci/workflow-scm-step-plugin/blob/master/README.md)
-   [Pipeline demo Docker
    image](https://github.com/jenkinsci/workflow-aggregator-plugin/blob/master/demo/README.md)

Formerly known as the Workflow plugin. Originally inspired by the discontinued [Build
Flow Plugin](https://github.com/jenkinsci/build-flow-plugin).

## Developer Notes

Plugins that implement Pipeline steps or integrate with Pipeline-related APIs **should not depend on `workflow-aggregator`** because it includes many unncessary dependencies.
Instead, they should depend only on the plugins that provide the APIs necessary for the integration.
For the common case of implementing a Pipeline step, plugins typically only need to depend on [`workflow-step-api`](https://plugins.jenkins.io/workflow-step-api/).
In order to test Pipeline-related functionality, plugins need `test`-scope dependencies on [`workflow-job`](https://plugins.jenkins.io/workflow-job/) and [`workflow-cps`](https://plugins.jenkins.io/workflow-cps/).
Additional `test`-scope dependencies on plugins like [`workflow-durable-task-step`](https://plugins.jenkins.io/workflow-durable-task-step) or [`workflow-basic-steps`](https://plugins.jenkins.io/workflow-basic-steps) may be needed for more complex tests.

## Version History
See [GitHub Releases](https://github.com/jenkinsci/workflow-aggregator-plugin/releases).
For older versions, see [historical changelog](https://github.com/jenkinsci/workflow-aggregator-plugin/blob/972e0fa8cb807739dcaf07be76e531aad72b847e/CHANGELOG.md).
