def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  def jobConfig = { readFileFromWorkspace("${path}") }
  assert jobConfig instanceof Closure
  
  def myJob = job("${name}") {
    jobConfig
  }

/*
  def myJob = job("${name}")
  myJob.with {
    readFileFromWorkspace("${path}")
  }
*/
}
