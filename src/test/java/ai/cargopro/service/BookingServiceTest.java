package ai.cargopro.service;

import ai.cargopro.dto.BookingDto;
import ai.cargopro.entity.Booking;
import ai.cargopro.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void testCreateBooking() {
        BookingDto bookingDto = new BookingDto();
        // minimal happy-path test
        Booking booking = bookingService.createBooking(bookingDto);
        assertNotNull(booking);
    }
}