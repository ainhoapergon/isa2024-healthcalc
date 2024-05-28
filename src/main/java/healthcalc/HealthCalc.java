package healthcalc;

/**
 * Calculator of some health parameters of persons.
 * 
 * @author ISA
 *
 */
public interface HealthCalc {
	
	/**
	 * Calculate the ideal weight (IW) of a person following the Lorentz formula:
	 * For men: IW = height - 100 - (height - 150) / 4)
	 * For women: IW = height - 100 - (height - 150) / 2.5)
	 *
	 * @param height 	Height of the person (cm).
	 * @param gender	Gender of the person (male or female).
	 * @return 		 	The ideal weight of the person (kg).
	 * @throws Exception 
	 */
	public float idealWeight(float height, Gender gender) throws Exception;
	
	/**
	 * Calculate the Basal Metabolic Rate (BMR) of a person with the following formula:
	 * For men: BMR = 10 * weight + 6.25 * height - 5 * age + 5
	 * For women: BMR = 10 * weight + 6.25 * height - 5 * age - 161
	 *   
	 * @param weight	Weight of the person (kg).
	 * @param height 	Height of the person (cm).
	 * @param gender	Gender of the person (male or female).
	 * @param age		Age of the person.
	 * @return	  		The Basal Metabolic Rate of the person.
	 * @throws Exception
	 */
	public float basalMetabolicRate(float weight, float height, Gender gender, int age) throws Exception;


	/**
	 * Calculate the Body Mass Index (BMI) of a person with the following formula:
	 * BMI = weight/height^2
	 *   
	 * @param weight	Weight of the person (kg).
	 * @param height 	Height of the person (cm).
	 * @return	  		The Body Mass Index of the person.
	 * @throws Exception
	 */
	public float bodyMassIndex(float weight, float height) throws Exception;

	/**
	 * Calculate the estimated heart rate zones of a person using the age.
	 * HeartRate = 220-age
	 * 
	 * For moderate-intensity physical activity:
	 * 64% HeartRate - 76% HeartRate
	 * 
	 * For vigorous-intensity physical activity:
	 * 77% HeartRate - 93% HeartRate
	 *   
	 * @param age		Age of the person.
	 * @return	  		The estimated heart rate zones.
	 * @throws Exception
	 */
	public String heartRateZones(int age) throws Exception;
}
