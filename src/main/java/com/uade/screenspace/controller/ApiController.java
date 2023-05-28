package com.uade.screenspace.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.uade.screenspace.models.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
public class ApiController implements Api {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public String hola(){
        return ("hola");
    }

    public ResponseEntity<Void> authsDelete() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> authsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AuthsBody1 body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{\n  \"token\" : \"token\"\n}", InlineResponse200.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> authsPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AuthsBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{\n  \"token\" : \"token\"\n}", InlineResponse200.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> cinemasCinemaIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of cinema to delete", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cinema> cinemasCinemaIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of cinema to delete", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cinema>(objectMapper.readValue("{\n  \"owner\" : {\n    \"profilePictureURL\" : \"profilePictureURL\",\n    \"isOwner\" : true,\n    \"name\" : \"name\",\n    \"email\" : \"\"\n  },\n  \"screeningsByDay\" : [ {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  }, {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  } ],\n  \"address\" : {\n    \"number\" : \"number\",\n    \"country\" : \"country\",\n    \"province\" : \"province\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"neighborhood\" : \"neighborhood\"\n  },\n  \"geoLocation\" : {\n    \"latitude\" : 0.8008281904610115,\n    \"longitude\" : 6.027456183070403\n  },\n  \"name\" : \"name\",\n  \"pricePerFunction\" : 1.4658129805029452\n}", Cinema.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cinema>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cinema>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cinema> cinemasCinemaIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of cinema to delete", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UpdateCinemaRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cinema>(objectMapper.readValue("{\n  \"owner\" : {\n    \"profilePictureURL\" : \"profilePictureURL\",\n    \"isOwner\" : true,\n    \"name\" : \"name\",\n    \"email\" : \"\"\n  },\n  \"screeningsByDay\" : [ {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  }, {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  } ],\n  \"address\" : {\n    \"number\" : \"number\",\n    \"country\" : \"country\",\n    \"province\" : \"province\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"neighborhood\" : \"neighborhood\"\n  },\n  \"geoLocation\" : {\n    \"latitude\" : 0.8008281904610115,\n    \"longitude\" : 6.027456183070403\n  },\n  \"name\" : \"name\",\n  \"pricePerFunction\" : 1.4658129805029452\n}", Cinema.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cinema>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cinema>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Theater>> cinemasCinemaIdTheatersGet(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Theater>>(objectMapper.readValue("[ {\n  \"seatsLayout\" : {\n    \"numRows\" : 5,\n    \"numColumns\" : 5\n  },\n  \"name\" : \"name\",\n  \"isTemporarilyClosed\" : true\n}, {\n  \"seatsLayout\" : {\n    \"numRows\" : 5,\n    \"numColumns\" : 5\n  },\n  \"name\" : \"name\",\n  \"isTemporarilyClosed\" : true\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Theater>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Theater>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Theater> cinemasCinemaIdTheatersPost(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("cinemaId") Integer cinemaId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Theater body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Theater>(objectMapper.readValue("{\n  \"seatsLayout\" : {\n    \"numRows\" : 5,\n    \"numColumns\" : 5\n  },\n  \"name\" : \"name\",\n  \"isTemporarilyClosed\" : true\n}", Theater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Theater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Theater>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Cinema>> cinemasGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Cinema>>(objectMapper.readValue("[ {\n  \"owner\" : {\n    \"profilePictureURL\" : \"profilePictureURL\",\n    \"isOwner\" : true,\n    \"name\" : \"name\",\n    \"email\" : \"\"\n  },\n  \"screeningsByDay\" : [ {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  }, {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  } ],\n  \"address\" : {\n    \"number\" : \"number\",\n    \"country\" : \"country\",\n    \"province\" : \"province\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"neighborhood\" : \"neighborhood\"\n  },\n  \"geoLocation\" : {\n    \"latitude\" : 0.8008281904610115,\n    \"longitude\" : 6.027456183070403\n  },\n  \"name\" : \"name\",\n  \"pricePerFunction\" : 1.4658129805029452\n}, {\n  \"owner\" : {\n    \"profilePictureURL\" : \"profilePictureURL\",\n    \"isOwner\" : true,\n    \"name\" : \"name\",\n    \"email\" : \"\"\n  },\n  \"screeningsByDay\" : [ {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  }, {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  } ],\n  \"address\" : {\n    \"number\" : \"number\",\n    \"country\" : \"country\",\n    \"province\" : \"province\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"neighborhood\" : \"neighborhood\"\n  },\n  \"geoLocation\" : {\n    \"latitude\" : 0.8008281904610115,\n    \"longitude\" : 6.027456183070403\n  },\n  \"name\" : \"name\",\n  \"pricePerFunction\" : 1.4658129805029452\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Cinema>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Cinema>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cinema> cinemasPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateCinemaRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Cinema>(objectMapper.readValue("{\n  \"owner\" : {\n    \"profilePictureURL\" : \"profilePictureURL\",\n    \"isOwner\" : true,\n    \"name\" : \"name\",\n    \"email\" : \"\"\n  },\n  \"screeningsByDay\" : [ {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  }, {\n    \"date\" : \"2000-01-23\",\n    \"screenings\" : [ {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    }, {\n      \"seatsReserved\" : [ {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      }, {\n        \"seatRow\" : 7.061401241503109,\n        \"seatColumn\" : 9.301444243932576\n      } ],\n      \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"movie\" : [ {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      }, {\n        \"image\" : \"http://example.com/aeiou\",\n        \"genre\" : \"genre\",\n        \"rating\" : 2.3021358869347655,\n        \"synopsis\" : \"synopsis\",\n        \"title\" : \"title\"\n      } ],\n      \"theater\" : {\n        \"seatsLayout\" : {\n          \"numRows\" : 5,\n          \"numColumns\" : 5\n        },\n        \"name\" : \"name\",\n        \"isTemporarilyClosed\" : true\n      }\n    } ]\n  } ],\n  \"address\" : {\n    \"number\" : \"number\",\n    \"country\" : \"country\",\n    \"province\" : \"province\",\n    \"city\" : \"city\",\n    \"street\" : \"street\",\n    \"neighborhood\" : \"neighborhood\"\n  },\n  \"geoLocation\" : {\n    \"latitude\" : 0.8008281904610115,\n    \"longitude\" : 6.027456183070403\n  },\n  \"name\" : \"name\",\n  \"pricePerFunction\" : 1.4658129805029452\n}", Cinema.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Cinema>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Cinema>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> cinemasTheatersTheaterIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of theater", required=true, schema=@Schema()) @PathVariable("theaterId") Integer theaterId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Theater> cinemasTheatersTheaterIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of theater", required=true, schema=@Schema()) @PathVariable("theaterId") Integer theaterId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Theater>(objectMapper.readValue("{\n  \"seatsLayout\" : {\n    \"numRows\" : 5,\n    \"numColumns\" : 5\n  },\n  \"name\" : \"name\",\n  \"isTemporarilyClosed\" : true\n}", Theater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Theater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Theater>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Theater> cinemasTheatersTheaterIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of theater", required=true, schema=@Schema()) @PathVariable("theaterId") Integer theaterId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Theater body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Theater>(objectMapper.readValue("{\n  \"seatsLayout\" : {\n    \"numRows\" : 5,\n    \"numColumns\" : 5\n  },\n  \"name\" : \"name\",\n  \"isTemporarilyClosed\" : true\n}", Theater.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Theater>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Theater>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> forgotPasswordPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ForgotpasswordBody body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<HealthCheckResponse> healthGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<HealthCheckResponse>(objectMapper.readValue("{\n  \"details\" : { },\n  \"status\" : \"status\"\n}", HealthCheckResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<HealthCheckResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<HealthCheckResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Qualification>> movieIdQualificationsGet(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("movieId") Integer movieId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Qualification>>(objectMapper.readValue("[ {\n  \"rating\" : {\n    \"rating\" : 0.8008281904610115,\n    \"comment\" : {\n      \"comment\" : \"comment\"\n    },\n    \"user\" : {\n      \"profilePictureURL\" : \"profilePictureURL\",\n      \"isOwner\" : true,\n      \"name\" : \"name\",\n      \"email\" : \"\"\n    }\n  }\n}, {\n  \"rating\" : {\n    \"rating\" : 0.8008281904610115,\n    \"comment\" : {\n      \"comment\" : \"comment\"\n    },\n    \"user\" : {\n      \"profilePictureURL\" : \"profilePictureURL\",\n      \"isOwner\" : true,\n      \"name\" : \"name\",\n      \"email\" : \"\"\n    }\n  }\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Qualification>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Qualification>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> movieIdQualificationsPost(@Parameter(in = ParameterIn.PATH, description = "ID of cinema", required=true, schema=@Schema()) @PathVariable("movieId") Integer movieId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Qualification body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Movie>> moviesGet(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "movieTitle", required = false) String movieTitle) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Movie>>(objectMapper.readValue("[ {\n  \"image\" : \"http://example.com/aeiou\",\n  \"genre\" : \"genre\",\n  \"rating\" : 2.3021358869347655,\n  \"synopsis\" : \"synopsis\",\n  \"title\" : \"title\"\n}, {\n  \"image\" : \"http://example.com/aeiou\",\n  \"genre\" : \"genre\",\n  \"rating\" : 2.3021358869347655,\n  \"synopsis\" : \"synopsis\",\n  \"title\" : \"title\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Movie>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Movie> moviesMovieIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of movie", required=true, schema=@Schema()) @PathVariable("movieId") Integer movieId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Movie>(objectMapper.readValue("{\n  \"image\" : \"http://example.com/aeiou\",\n  \"genre\" : \"genre\",\n  \"rating\" : 2.3021358869347655,\n  \"synopsis\" : \"synopsis\",\n  \"title\" : \"title\"\n}", Movie.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Movie>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Movie>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Reservation> reservationsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateReservationRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Reservation>(objectMapper.readValue("{\n  \"seatsReserved\" : [ {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  }, {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  } ],\n  \"screening\" : {\n    \"seatsReserved\" : [ {\n      \"seatRow\" : 7.061401241503109,\n      \"seatColumn\" : 9.301444243932576\n    }, {\n      \"seatRow\" : 7.061401241503109,\n      \"seatColumn\" : 9.301444243932576\n    } ],\n    \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"movie\" : [ {\n      \"image\" : \"http://example.com/aeiou\",\n      \"genre\" : \"genre\",\n      \"rating\" : 2.3021358869347655,\n      \"synopsis\" : \"synopsis\",\n      \"title\" : \"title\"\n    }, {\n      \"image\" : \"http://example.com/aeiou\",\n      \"genre\" : \"genre\",\n      \"rating\" : 2.3021358869347655,\n      \"synopsis\" : \"synopsis\",\n      \"title\" : \"title\"\n    } ],\n    \"theater\" : {\n      \"seatsLayout\" : {\n        \"numRows\" : 5,\n        \"numColumns\" : 5\n      },\n      \"name\" : \"name\",\n      \"isTemporarilyClosed\" : true\n    }\n  },\n  \"code\" : 0.8008281904610115,\n  \"cinema\" : {\n    \"owner\" : {\n      \"profilePictureURL\" : \"profilePictureURL\",\n      \"isOwner\" : true,\n      \"name\" : \"name\",\n      \"email\" : \"\"\n    },\n    \"screeningsByDay\" : [ {\n      \"date\" : \"2000-01-23\",\n      \"screenings\" : [ {\n        \"seatsReserved\" : [ {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        }, {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        } ],\n        \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"movie\" : [ {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        }, {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        } ],\n        \"theater\" : {\n          \"seatsLayout\" : {\n            \"numRows\" : 5,\n            \"numColumns\" : 5\n          },\n          \"name\" : \"name\",\n          \"isTemporarilyClosed\" : true\n        }\n      }, {\n        \"seatsReserved\" : [ {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        }, {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        } ],\n        \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"movie\" : [ {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        }, {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        } ],\n        \"theater\" : {\n          \"seatsLayout\" : {\n            \"numRows\" : 5,\n            \"numColumns\" : 5\n          },\n          \"name\" : \"name\",\n          \"isTemporarilyClosed\" : true\n        }\n      } ]\n    }, {\n      \"date\" : \"2000-01-23\",\n      \"screenings\" : [ {\n        \"seatsReserved\" : [ {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        }, {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        } ],\n        \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"movie\" : [ {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        }, {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        } ],\n        \"theater\" : {\n          \"seatsLayout\" : {\n            \"numRows\" : 5,\n            \"numColumns\" : 5\n          },\n          \"name\" : \"name\",\n          \"isTemporarilyClosed\" : true\n        }\n      }, {\n        \"seatsReserved\" : [ {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        }, {\n          \"seatRow\" : 7.061401241503109,\n          \"seatColumn\" : 9.301444243932576\n        } ],\n        \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"movie\" : [ {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        }, {\n          \"image\" : \"http://example.com/aeiou\",\n          \"genre\" : \"genre\",\n          \"rating\" : 2.3021358869347655,\n          \"synopsis\" : \"synopsis\",\n          \"title\" : \"title\"\n        } ],\n        \"theater\" : {\n          \"seatsLayout\" : {\n            \"numRows\" : 5,\n            \"numColumns\" : 5\n          },\n          \"name\" : \"name\",\n          \"isTemporarilyClosed\" : true\n        }\n      } ]\n    } ],\n    \"address\" : {\n      \"number\" : \"number\",\n      \"country\" : \"country\",\n      \"province\" : \"province\",\n      \"city\" : \"city\",\n      \"street\" : \"street\",\n      \"neighborhood\" : \"neighborhood\"\n    },\n    \"geoLocation\" : {\n      \"latitude\" : 0.8008281904610115,\n      \"longitude\" : 6.027456183070403\n    },\n    \"name\" : \"name\",\n    \"pricePerFunction\" : 1.4658129805029452\n  },\n  \"user\" : {\n    \"profilePictureURL\" : \"profilePictureURL\",\n    \"isOwner\" : true,\n    \"name\" : \"name\",\n    \"email\" : \"\"\n  }\n}", Reservation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Reservation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> resetPasswordConfirmPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ResetpasswordConfirmBody body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> resetPasswordPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ResetpasswordBody body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<TimeSlot>> screeningsAvailabilityGet(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "cinema", required = true) Integer cinema,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "movieTitle", required = true) String movieTitle,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "date", required = true) LocalDate date) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<TimeSlot>>(objectMapper.readValue("[ {\n  \"start\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"end\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"start\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"end\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<TimeSlot>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<TimeSlot>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Screening>> screeningsGet(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "cinema", required = false) Integer cinema,@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "movieTitle", required = false) String movieTitle,@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "genre", required = false) String genre,@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "score", required = false) String score,@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "latitute", required = false) String latitute,@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "longitude", required = false) String longitude) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Screening>>(objectMapper.readValue("[ {\n  \"seatsReserved\" : [ {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  }, {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  } ],\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"movie\" : [ {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  }, {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  } ],\n  \"theater\" : {\n    \"seatsLayout\" : {\n      \"numRows\" : 5,\n      \"numColumns\" : 5\n    },\n    \"name\" : \"name\",\n    \"isTemporarilyClosed\" : true\n  }\n}, {\n  \"seatsReserved\" : [ {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  }, {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  } ],\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"movie\" : [ {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  }, {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  } ],\n  \"theater\" : {\n    \"seatsLayout\" : {\n      \"numRows\" : 5,\n      \"numColumns\" : 5\n    },\n    \"name\" : \"name\",\n    \"isTemporarilyClosed\" : true\n  }\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Screening>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Screening>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Screening> screeningsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateScreeningRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Screening>(objectMapper.readValue("{\n  \"seatsReserved\" : [ {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  }, {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  } ],\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"movie\" : [ {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  }, {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  } ],\n  \"theater\" : {\n    \"seatsLayout\" : {\n      \"numRows\" : 5,\n      \"numColumns\" : 5\n    },\n    \"name\" : \"name\",\n    \"isTemporarilyClosed\" : true\n  }\n}", Screening.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Screening>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Screening>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> screeningsScreeningIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of screening", required=true, schema=@Schema()) @PathVariable("screeningId") Integer screeningId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Screening> screeningsScreeningIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of screening", required=true, schema=@Schema()) @PathVariable("screeningId") Integer screeningId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Screening>(objectMapper.readValue("{\n  \"seatsReserved\" : [ {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  }, {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  } ],\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"movie\" : [ {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  }, {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  } ],\n  \"theater\" : {\n    \"seatsLayout\" : {\n      \"numRows\" : 5,\n      \"numColumns\" : 5\n    },\n    \"name\" : \"name\",\n    \"isTemporarilyClosed\" : true\n  }\n}", Screening.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Screening>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Screening>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Screening> screeningsScreeningIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of screening", required=true, schema=@Schema()) @PathVariable("screeningId") Integer screeningId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UpdateScreeningRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Screening>(objectMapper.readValue("{\n  \"seatsReserved\" : [ {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  }, {\n    \"seatRow\" : 7.061401241503109,\n    \"seatColumn\" : 9.301444243932576\n  } ],\n  \"date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"movie\" : [ {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  }, {\n    \"image\" : \"http://example.com/aeiou\",\n    \"genre\" : \"genre\",\n    \"rating\" : 2.3021358869347655,\n    \"synopsis\" : \"synopsis\",\n    \"title\" : \"title\"\n  } ],\n  \"theater\" : {\n    \"seatsLayout\" : {\n      \"numRows\" : 5,\n      \"numColumns\" : 5\n    },\n    \"name\" : \"name\",\n    \"isTemporarilyClosed\" : true\n  }\n}", Screening.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Screening>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Screening>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> usersMeDelete() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<User>> usersMeGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<User>>(objectMapper.readValue("[ {\n  \"profilePictureURL\" : \"profilePictureURL\",\n  \"isOwner\" : true,\n  \"name\" : \"name\",\n  \"email\" : \"\"\n}, {\n  \"profilePictureURL\" : \"profilePictureURL\",\n  \"isOwner\" : true,\n  \"name\" : \"name\",\n  \"email\" : \"\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> usersMePut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"profilePictureURL\" : \"profilePictureURL\",\n  \"isOwner\" : true,\n  \"name\" : \"name\",\n  \"email\" : \"\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse201> usersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsersBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse201>(objectMapper.readValue("{\n  \"message\" : \"message\"\n}", InlineResponse201.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse201>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse201>(HttpStatus.NOT_IMPLEMENTED);
    }

}
