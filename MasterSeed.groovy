def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  def clo = evaluate(readFileFromWorkspace("${path}"))
  
  job(name, clo)
}
