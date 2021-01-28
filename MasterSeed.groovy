job('example-1') {
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
