package test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.bean.PublicTravelBean;
import logic.controllers.JoinController;
import logic.exceptions.DuplicateRequestException;
import logic.exceptions.SystemException;

public class TestJoinController {
	
	/* Autor: Enrico D'Alessandro - Test 7 */
	@Test
	public void testSendJoinRequestForNewTravel() {
		JoinController joinController = new JoinController();
		int result = 0;
		
		PublicTravelBean publicTravelBean = new PublicTravelBean();
		publicTravelBean.setIdTravelBean("10");

		try {
			joinController.sendJoinRequest(publicTravelBean, "Cecco");
			result = 1;
		} catch (SystemException|DuplicateRequestException e) {
			result = 0;
		}
		
		assertEquals(1, result);
	}
	
	/* Autor: Enrico D'Alessandro - Test 8 */
	@Test
	public void testSendJoinRequestAlreadySent() {
		JoinController joinController = new JoinController();
		int result = 0;
		
		PublicTravelBean publicTravelBean = new PublicTravelBean();
		publicTravelBean.setIdTravelBean("10");
		
		try {
			joinController.sendJoinRequest(publicTravelBean, "Cecco");
			result = 1;
		} catch (SystemException|DuplicateRequestException e) {
			result = 0;
		}
		
		assertEquals(0, result);
	}
	
}
