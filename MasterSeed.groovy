def configSlurper = new ConfigSlurper()

def seedConfig = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

seedConfig.seedJobs.each { name, path ->
  def jobConfig = { readFileFromWorkspace("${path}") }
  assert jobConfig instanceof Closure
  
  job("${name}") {
    
    scm {
      git {
          remote {
              name('remoteB')
              url('git@server:account/repo1.git')
          }
          extensions {
              cleanAfterCheckout()
              relativeTargetDirectory('repo1')
          }
      }
    }
    
  }

/*
  def myJob = job("${name}")
  myJob.with {
    readFileFromWorkspace("${path}")
  }
*/
}
