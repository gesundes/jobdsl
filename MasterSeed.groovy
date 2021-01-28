def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  def jobConfig = { readFileFromWorkspace("${path}") }
  
  job("${name}") {
  }

/*
  def myJob = job("${name}")
  myJob.with {
    readFileFromWorkspace("${path}")
  }
*/
}
