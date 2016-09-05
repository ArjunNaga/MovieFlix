package Movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Movieflix.entity.Rating;
import Movieflix.exception.RatingAlreadyExistException;
import Movieflix.exception.RatingNotFoundException;
import Movieflix.repository.RatingRepository;


@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	

	
	@Override
	public Rating findOne(String ratingId) {
		Rating rating = ratingRepository.findOne(ratingId);
		if (rating == null) {
			throw new RatingNotFoundException("Rating not found");
		}
		return rating; 
	}

	@Transactional
	@Override
	public Rating create(Rating rating) {
		Rating existing = ratingRepository.findByRanking(rating.getMovieRanking());
		if (existing != null) {
			throw new RatingAlreadyExistException("Rating already exists");
		}
		return ratingRepository.create(rating);
	}

	@Transactional
	@Override
	public Rating update(String ratingId, Rating rating) {
		Rating existing = ratingRepository.findOne(ratingId);
		if (existing == null) {
			throw new RatingNotFoundException("Rating not found");
		}
		return ratingRepository.update(rating);
	}

	@Transactional
	@Override
	public void remove(String ratingId) {
		Rating existing = ratingRepository.findOne(ratingId);
		if (existing == null) {
			throw new RatingNotFoundException("Rating not found");
		}
		ratingRepository.delete(existing);
	}

	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}


}