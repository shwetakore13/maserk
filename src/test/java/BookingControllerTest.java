import com.maersk.BookingController;
import com.maersk.BookingService;
import com.maersk.Container;
import com.maersk.ResponseDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookingControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    BookingController bookingController;
    @Mock
    BookingService bookingService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testBooking() throws Exception{
        ResponseDto responseDto = new ResponseDto(true);
        when(bookingService.saveBooking(new Container())).thenReturn(responseDto);
        MvcResult result = mockMvc.perform(get("/api/bookings")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
