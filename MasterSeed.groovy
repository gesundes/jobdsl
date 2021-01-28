def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
/*
  Closure jobConfig = { readFileFromWorkspace("${path}") }
  
  job("${name}", jobConfig)
*/

  def myJob = job("${name}")
  myJob.with {
    { it -> readFileFromWorkspace("${path}") }
  }

}
