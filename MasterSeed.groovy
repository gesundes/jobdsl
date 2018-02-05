def configSlurper = new ConfigSlurper()

def config = configSlurper.parse(readFileFromWorkspace("seedConfig.cfg"))

config.each { name, path ->
  job "${name}", readFileFromWorkspace($path)
}
