package Movieflix.service;

import java.util.List;

import Movieflix.entity.Rating;

public interface RatingService {

	public Rating findOne(String ratingId);

	public Rating create(Rating rating);

	public Rating update(String ratingId, Rating rating);

	public void remove(String ratingId);

	public List<Rating> findAll();
}
