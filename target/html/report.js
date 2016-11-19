$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FileInputOutput.feature");
formatter.feature({
  "line": 1,
  "name": "This is a sample feature for FileInput and output scenarios",
  "description": "",
  "id": "this-is-a-sample-feature-for-fileinput-and-output-scenarios",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "# Assumptions:"
    },
    {
      "line": 4,
      "value": "#This scanrio runs locally. And it is a template scenario"
    },
    {
      "line": 5,
      "value": "# We assume the input file is in the local input source folder"
    },
    {
      "line": 6,
      "value": "# And output files are also available in the output folders"
    }
  ],
  "line": 8,
  "name": "CopyMxf file and verify the output in the output folder",
  "description": "",
  "id": "this-is-a-sample-feature-for-fileinput-and-output-scenarios;copymxf-file-and-verify-the-output-in-the-output-folder",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I have mxf file in the input source folder",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I copy the input mxf file to the aspera watch folder",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I wait for file processing",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I should see the processed mxf and metadata xml in the output folder",
  "keyword": "Then "
});
formatter.match({
  "location": "FileInputOutputSteps.verifyInputFile()"
});
formatter.result({
  "duration": 205308336,
  "status": "passed"
});
formatter.match({
  "location": "FileInputOutputSteps.copyMxfFile()"
});
