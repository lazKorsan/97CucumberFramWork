package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.AdminPages;
import utilities.ReusableMethods;

public class DF039_GetListVaccinationsAndDeleteStepdefinitons {
    AdminPages adminPages = new AdminPages() ;


    @Then("TakeAlistVaccinationsAndDeleteVaccinations")
    public void take_alist_vaccinations_and_delete_vaccinations() {

        ReusableMethods.scrollToBottom();

        adminPages.deleteVaccinationsButton.click();


    }


}
