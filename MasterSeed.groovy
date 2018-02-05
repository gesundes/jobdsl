def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  def jobConfig = readFileFromWorkspace("${path}")
  println "${jobConfig}"
  
  def myJob = job("${name}") {
    readFileFromWorkspace("${path}")
  }
}
