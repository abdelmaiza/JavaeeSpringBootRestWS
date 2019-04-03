package com.wiredbrain.friends.controller;

import com.wiredbrain.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    FriendController friendController;

    @Test
    public void testCreateReadDelete(){
        Friend friend = new Friend("Gorder","Moore");
        Friend friendResult = friendController.create(friend);

        Iterable<Friend> friends = friendController.read();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName","Gorder");

        friendController.delete(friendResult.getId());
        Assertions.assertThat(friendController.read()).isEmpty();
    }
}
