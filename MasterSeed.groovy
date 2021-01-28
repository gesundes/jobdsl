job("JobName") {
    scm {
        git("git://github.com/${project}.git", branchName)
    }
    steps {
        maven("test -Dproject.name=${project}/${branchName}")
    }
}
