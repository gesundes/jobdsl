def job = {
  triggers {
    cron("@hourly")
  }
  steps {
    shell("echo 'Hello World'")
  }
}
