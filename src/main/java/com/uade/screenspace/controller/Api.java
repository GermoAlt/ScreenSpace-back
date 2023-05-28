package com.uade.screenspace.controller;

import com.uade.screenspace.models.*;
import com.uade.screenspace.models.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface Api {

    @RequestMapping(value = "/v1/hola",
            produces = { "application/json" },
            method = RequestMethod.GET)
    String hola();

    @Operation(summary = "Logs out user", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User logged out"),
        
        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable, offline error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/auths",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> authsDelete();


    @Operation(summary = "Log in an existing user", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User logged in successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request, invalid input", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable, offline error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/auths",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<InlineResponse200> authsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AuthsBody1 body);


    @Operation(summary = "Refresh access token", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "New access token retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request, invalid input", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access, invalid refresh token", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable, offline error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/auths",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<InlineResponse200> authsPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AuthsBody body);


    @Operation(summary = "Delete cinema by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Cinemas" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Cinema deleted successfully"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Cinema not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/cinemas/{cinemaId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> cinemasCinemaIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of cinema to delete", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId);


    @Operation(summary = "Get cinema details by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Cinemas" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Cinema details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cinema.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Cinema not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/cinemas/{cinemaId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Cinema> cinemasCinemaIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of cinema to delete", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId);


    @Operation(summary = "Update cinema details by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Cinemas" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Cinema details updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cinema.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Cinema not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/cinemas/{cinemaId}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Cinema> cinemasCinemaIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of cinema to delete", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UpdateCinemaRequest body);


    @Operation(summary = "Get list of theaters for cinema", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Theaters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of theaters", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Theater.class)))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/cinemas/{cinemaId}/theaters",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Theater>> cinemasCinemaIdTheatersGet(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId);


    @Operation(summary = "Add new theater to cinema", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Theaters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Theater added successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Theater.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/cinemas/{cinemaId}/theaters",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Theater> cinemasCinemaIdTheatersPost(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Theater body);


    @Operation(summary = "Get list of cinemas", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Cinemas" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of cinemas", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Cinema.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
        @RequestMapping(value = "/v1/cinemas",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Cinema>> cinemasGet();


    @Operation(summary = "Add new cinema", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Cinemas" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Cinema added successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cinema.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/cinemas",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Cinema> cinemasPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateCinemaRequest body);


    @Operation(summary = "Delete theater by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Theaters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Theater deleted successfully"),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/cinemas/theaters/{theaterId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> cinemasTheatersTheaterIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of theater", required=true, schema=@Schema()) @PathVariable("theaterId") Integer theaterId);


    @Operation(summary = "Get details of a theater", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Theaters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Theater details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Theater.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Theater not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/cinemas/theaters/{theaterId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Theater> cinemasTheatersTheaterIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of theater", required=true, schema=@Schema()) @PathVariable("theaterId") Integer theaterId);


    @Operation(summary = "Updates theater info", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Theaters" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Theater edited successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Theater.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/cinemas/theaters/{theaterId}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Theater> cinemasTheatersTheaterIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of theater", required=true, schema=@Schema()) @PathVariable("theaterId") Integer theaterId, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Theater body);


    @Operation(summary = "Forgot user password", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Success"),
        
        @ApiResponse(responseCode = "400", description = "Invalid email address provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ForgotPasswordError.class))) })
    @RequestMapping(value = "/v1/forgot-password",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> forgotPasswordPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ForgotpasswordBody body);


    @Operation(summary = "Check the health of the server", description = "Returns status 200 if the server is healthy", tags={ "Healthcheck" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "The server is healthy", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HealthCheckResponse.class))),
        
        @ApiResponse(responseCode = "503", description = "The server is unavailable") })
    @RequestMapping(value = "/v1/health",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<HealthCheckResponse> healthGet();


    @Operation(summary = "Get qualifications for a movie", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Qualifications" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of qualifications", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Qualification.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/{movieId}/qualifications",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Qualification>> movieIdQualificationsGet(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("movieId") Integer movieId);


    @Operation(summary = "Adds a new qualification", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Qualifications" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Qualification added successfully"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/{movieId}/qualifications",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> movieIdQualificationsPost(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("movieId") Integer movieId, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Qualification body);


    @Operation(summary = "Get movies", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Movies" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Movies", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Movie.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Movies not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/movies",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Movie>> moviesGet(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "movieTitle", required = false) String movieTitle);


    @Operation(summary = "Get movie by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Movies" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Movie details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Movie not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/movies/{movieId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Movie> moviesMovieIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of movie", required=true, schema=@Schema()) @PathVariable("movieId") Integer movieId);


    @Operation(summary = "Adds new reservation", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Reservations" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Reservation created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Reservation.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/reservations",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Reservation> reservationsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateReservationRequest body);


    @Operation(summary = "Confirm reset password", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Success"),
        
        @ApiResponse(responseCode = "400", description = "Invalid reset password token or password provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse400.class))) })
    @RequestMapping(value = "/v1/reset-password/confirm",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> resetPasswordConfirmPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ResetpasswordConfirmBody body);


    @Operation(summary = "Reset user password", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Success"),
        
        @ApiResponse(responseCode = "400", description = "Invalid email address provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResetPasswordError.class))) })
    @RequestMapping(value = "/v1/reset-password",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> resetPasswordPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ResetpasswordBody body);


    @Operation(summary = "Search free time slots for screenings", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Screenings" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of free time slots", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TimeSlot.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/screenings/availability",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TimeSlot>> screeningsAvailabilityGet(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "cinema", required = true) Integer cinema, @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "movieTitle", required = true) String movieTitle, @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "date", required = true) LocalDate date);


    @Operation(summary = "Search screenings", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Screenings" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of found screenings", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Screening.class)))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/screenings",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Screening>> screeningsGet(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "cinema", required = false) Integer cinema, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "movieTitle", required = false) String movieTitle, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "genre", required = false) String genre, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "score", required = false) String score, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "latitute", required = false) String latitute, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "longitude", required = false) String longitude);


    @Operation(summary = "Add a new screening", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Screenings" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Screening added successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Screening.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/screenings",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Screening> screeningsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateScreeningRequest body);


    @Operation(summary = "Delete screening by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Screenings" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Screening deleted successfully"),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Screening not found"),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/screenings/{screeningId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> screeningsScreeningIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of screening", required=true, schema=@Schema()) @PathVariable("screeningId") Integer screeningId);


    @Operation(summary = "Get screening by ID", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Screenings" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Screening details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Screening.class))),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Screening not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/screenings/{screeningId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Screening> screeningsScreeningIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of screening", required=true, schema=@Schema()) @PathVariable("screeningId") Integer screeningId);


    @Operation(summary = "Updates screening information", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Screenings" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Screening edited successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Screening.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Screening not found"),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/screenings/{screeningId}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Screening> screeningsScreeningIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of screening", required=true, schema=@Schema()) @PathVariable("screeningId") Integer screeningId, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UpdateScreeningRequest body);


    @Operation(summary = "Deletes logged user", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User deleted successfully"),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "User not found"),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> usersMeDelete();


    @Operation(summary = "Get info about logged user", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User info", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable"),
        
        @ApiResponse(responseCode = "504", description = "Gateway timeout") })
    @RequestMapping(value = "/v1/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> usersMeGet();


    @Operation(summary = "Updates logged user information", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User info updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request"),
        
        @ApiResponse(responseCode = "401", description = "Unauthorized access", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "User not found"),
        
        @ApiResponse(responseCode = "500", description = "Server error"),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable") })
    @RequestMapping(value = "/v1/users/me",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<User> usersMePut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body);


    @Operation(summary = "Register a new user", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "User Management" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "User registered successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse201.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request, invalid input", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "500", description = "Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "503", description = "Service unavailable, offline error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/v1/users",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<InlineResponse201> usersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsersBody body);

}

