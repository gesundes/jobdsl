  scm {
    github('jenkinsci/job-dsl-plugin', 'master')
  }
  triggers {
    cron("@hourly")
  }
  steps {
    shell("echo 'Hello World'")
  }
