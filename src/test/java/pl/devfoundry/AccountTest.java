package pl.devfoundry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account account = new Account();

        //then
        Assertions.assertFalse(account.isActive(), "Check if new account is not active");
        assertThat(account.isActive(), equalTo(false));
        assertThat(account.isActive(), is(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation () {
        Account account = new Account();
        account.activate();
        Assertions.assertTrue(account.isActive());
        assertThat(account.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDeliveryAddressSet() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(account.isActive(), is(notNullValue()));
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Krakowska", "67C");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultDeliveryAddress);
        assertThat(defaultDeliveryAddress, is(notNullValue()));
    }
}
