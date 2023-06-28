package au.com.dmg.fusion.request.paymentrequest.extenstiondata;

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    @Json(name = "TotalDistanceTravelled")
    private final BigDecimal totalDistanceTravelled;
    @Json(name = "Stops")
    private final List<Stop> stops;

    @NotNull
    public BigDecimal getTotalDistanceTravelled(){ return totalDistanceTravelled; }
    @NotNull
    public List<Stop> getStops(){ return stops; }

    public static class Builder{
        private BigDecimal totalDistanceTravelled;
        private  List<Stop> stops = new ArrayList<>();;

        public Builder(){
        }

        Builder(BigDecimal totalDistanceTravelled, List<Stop> stops){
            this.totalDistanceTravelled = totalDistanceTravelled;
            this.stops = stops;
        }

        public Builder totalDistanceTravelled(BigDecimal totalDistanceTravelled){
            this.totalDistanceTravelled = totalDistanceTravelled;
            return Builder.this;
        }

        public Builder stops(List<Stop> stops){
            if(stops == null){
                this.stops = new ArrayList<>();
            } else {
                this.stops = stops;
            }
            return Builder.this;
        }

        public Builder addStop(Stop stop) {
            this.stops.add(stop);
            return Builder.this;
        }

        public Builder addStops(List<Stop> stops) {
            this.stops.addAll(stops);
            return Builder.this;
        }

        public Trip build(){
            if (this.totalDistanceTravelled == null) {
                throw new NullPointerException("The property \"totalDistanceTravelled\" is null. "
                        + "Please set the Value by \"totalDistanceTravelled()\". "
                        + "the properties \"totalDistanceTravelled\" and \"stops\" are required.");
            }

            if (this.stops == null) {
                throw new NullPointerException("The property \"stops\" is null. "
                        + "Please set the Value by \"stops()\". "
                        + "the properties \"totalDistanceTravelled\" and \"stops\" are required.");
            }

            if (this.stops.size() < 2) { //&& trip.size() == 0; //check if this works
                throw new NullPointerException("The property \"Stops\" is invalid. "
                        + "Please set the Value by \"stops()\". "
                        + "the properties \"Stops\" should contain a minimum of two entries which indicate start and end of the trip.");
            }
            return new Trip(this);
        }
    }

    private Trip(BigDecimal totalDistanceTravelled, List<Stop> stops) {
        this.totalDistanceTravelled = totalDistanceTravelled;
        this.stops = stops;
    }
    private Trip(Builder builder){
        this.totalDistanceTravelled = builder.totalDistanceTravelled;
        this.stops = builder.stops;
    }

}