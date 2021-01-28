def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  Closure jobConfig = evaluate(readFileFromWorkspace("${path}"))
  assert jobConfig instanceof Closure
  
/*  def myJob = job("${name}") {
    readFileFromWorkspace("${path}")
  }

  def myJob = job("${name}")
  myJob.with {
    readFileFromWorkspace("${path}")
  }
*/
}
