import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/convert")
public class ConverterResource {

    @GET
    @Path("/pounds-to-kilograms")
    @Produces(MediaType.APPLICATION_JSON)
    public ConversionResult convertPoundsToKilograms(@QueryParam("pounds") double pounds) {
        double kilograms = pounds * 0.453592;
        return new ConversionResult(pounds, kilograms);
    }
}

public class ConversionResult {
    private double from;
    private double to;

    public ConversionResult(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}
