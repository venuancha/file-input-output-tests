Feature: This is a sample feature for FileInput and output scenarios

# Assumptions:
#This scanrio runs locally. And it is a template scenario
# We assume the input file is in the local input source folder
# And output files are also available in the output folders

Scenario: CopyMxf file and verify the output in the output folder
Given I have mxf file in the input source folder
When I copy the input mxf file to the aspera watch folder
And I wait for file processing
Then I should see the processed mxf and metadata xml in the output folder

