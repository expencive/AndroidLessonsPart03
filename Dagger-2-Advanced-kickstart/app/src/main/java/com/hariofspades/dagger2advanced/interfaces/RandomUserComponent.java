package com.hariofspades.dagger2advanced.interfaces;

import com.squareup.picasso.Picasso;

import dagger.Component;

@Component
public interface RandomUserComponent {
    RandomUsersApi getRandomUserService();
    Picasso getPicasso();
}
