package step_definitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;

import util.LoadProperties;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FileInputOutputSteps {

	static Properties prop;
	static Logger log = Logger.getLogger(FileInputOutputSteps.class);

	public FileInputOutputSteps() {
		// load properties file
		prop = LoadProperties.getInstance().loadProperties();
	}

	@Given("^I have mxf file in the input source folder$")
	public void verifyInputFile() {

		// This step verifies the input source have the media file
		boolean check = new File(prop.getProperty("FILE_INPUT_SOURCE_LOCATION")
				+ prop.getProperty("FILE_NAME")).exists();

		log.debug("Verifying the source input file");

		Assert.assertTrue(check == true);
	}

	@When("^I copy the input mxf file to the aspera watch folder$")
	public void copyMxfFile() throws IOException {

		// Copying the media file from input source to aspera watch folder
		File source = new File(prop.getProperty("FILE_INPUT_SOURCE_LOCATION")
				+ prop.getProperty("FILE_NAME"));
		File dest = new File(prop.getProperty("FILE_INPUT_LOCATION")
				+ prop.getProperty("FILE_NAME"));
		log.debug("Copying the input media file from source to the aspera input watch folder");
		Files.copy(source.toPath(), dest.toPath(),
				StandardCopyOption.REPLACE_EXISTING);
	}

	@And("^I wait for file processing$")
	public void waitForProcessing() throws InterruptedException {
		// Waiting for the file processing.
		log.debug("Waiting for the input media file to be processed");
		TimeUnit.SECONDS.sleep(5);
	}

	@Then("^I should see the processed mxf and metadata xml in the output folder$")
	public void verifyProcessedOutput() {

		// Verifying the output files in the output folder
		boolean check = new File(prop.getProperty("FILE_OUTPUT_LOCATION")
				+ prop.getProperty("FILE_NAME")).exists();

		log.debug("Verifying the ouptput folder for the output media file");
		// Verify output mxf file exists
		Assert.assertTrue(check == true);

		String fileNameProp = prop.getProperty("FILE_NAME");
		// Splitting the file name to create the file name for xml
		String[] fileName = fileNameProp.split("\\.");

		check = new File(prop.getProperty("FILE_OUTPUT_LOCATION") + fileName[0]
				+ ".xml").exists();
		log.debug("Verifying the ouptput folder for the output metadata xml file");
		// verify metadata xml exists
		Assert.assertTrue(check == true);
	}
}
