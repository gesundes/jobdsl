def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  Closure jobConfig = readFileFromWorkspace(${path})
  println "${jobConfig}"
  
/*  def myJob = job("${name}") {
    readFileFromWorkspace("${path}")
  }
*/
  def myJob = job("${name}")
  myJob.with {
    readFileFromWorkspace("${path}")
  }
}
