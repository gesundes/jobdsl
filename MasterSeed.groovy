def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  println(readFileFromWorkspace("${path}"))
  Closure jobConfig = { readFileFromWorkspace("${path}") }
  println(jobConfig)
  
  def content = {
        scm {
            git("git://github.com/${project}.git", branchName)
        }
  }
  
  job name content

/*
  def myJob = job("${name}")
  myJob.with {
    this.readFileFromWorkspace("${path}")
  }
*/
}
