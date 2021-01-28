def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  println(readFileFromWorkspace("${path}"))
  Closure jobConfig = { readFileFromWorkspace("${path}") }
  println(jobConfig)
  
  def closure = {
        scm {
            git("git://github.com/${project}.git", branchName)
        }
  }
  
  job name closure

/*
  def myJob = job("${name}")
  myJob.with {
    this.readFileFromWorkspace("${path}")
  }
*/
}
