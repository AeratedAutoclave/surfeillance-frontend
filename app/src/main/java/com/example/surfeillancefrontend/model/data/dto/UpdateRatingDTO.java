package com.example.surfeillancefrontend.model.data.dto;

public class UpdateRatingDTO {


    private int surfRating;
    private int infoRating;

    public UpdateRatingDTO(int surfRating, int infoRating) {
        this.surfRating = surfRating;
        this.infoRating = infoRating;
    }

    public Integer getSurfRating() {
        return surfRating;
    }

    public void setSurfRating(Integer surfRating) {
        this.surfRating = surfRating;
    }

    public Integer getInfoRating() {
        return infoRating;
    }

    public void setInfoRating(Integer infoRating) {
        this.infoRating = infoRating;
    }

    @Override
    public String toString() {
        return "UpdateRatingDTO{" +
                "surfRating=" + surfRating +
                ", infoRating=" + infoRating +
                '}';
    }
}