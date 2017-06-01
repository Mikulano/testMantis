node {
 
  	git url: 'https://github.com/mikulano/testMantis.git', branch: 'master'
  	sh "mvn clean test"
  	step([$class: 'CucumberReportPublisher',
        	failedFeaturesNumber: 0,
        	failedScenariosNumber: 0,
        	failedStepsNumber: 0, fileExcludePattern: '',
        	fileIncludePattern: '**/mainReport.json',
        	jsonReportDirectory: '',
        	pendingStepsNumber: 0,
        	skippedStepsNumber: 0,
        	undefinedStepsNumber: 0])
}

