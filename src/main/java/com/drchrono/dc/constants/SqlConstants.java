package com.drchrono.dc.constants;

public class SqlConstants {

  public final static String insertPatient =
      "INSERT INTO public.patient (id,chart_id,first_name,middle_name,"
          + "last_name,date_of_birth,gender,social_security_number,race,ethnicity,patient_photo,"
          + "patient_payment_profile,patient_status,home_phone,cell_phone,office_phone,email,"
          + "address,city,state,zip_code,emergency_contact_name,emergency_contact_phone,"
          + "emergency_contact_relation,employer,employer_address,employer_city,employer_state,"
          + "employer_zip_code,disable_sms_messages,doctor,primary_care_physician,"
          + "date_of_first_appointment,date_of_last_appointment,default_pharmacy,referring_source,"
          + "copay,responsible_party_name,responsible_party_relation,responsible_party_phone,"
          + "responsible_party_email,updated_at ) values "
          + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


  public final static String getPatient = "SELECT * from public.patient where id = :ID";


  public final static String getLatestPatient = "SELECT * from public.patient order by updated_dttm desc limit 1";


  public final static String insertAppointment =
      "INSERT into public.appointments (appointmentid,allow_overlapping,appt_is_break,"
          + "base_recurring_appointment,color,created_at,deleted_flag,doctor,duration,exam_room,"
          + "is_walk_in,notes,office,patient,profile,reason,recurring_appointment,scheduled_time,"
          + "status,updated_at) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


  public final static String insertMedication =
      "INSERT into public.medication (id,doctor,patient,appointment,date_prescribed,"
          + "date_started_taking,date_stopped_taking,notes,order_status,number_refills,"
          + "dispense_quantity,dosage_quantity,dosage_units,rxnorm,route,frequency,prn,"
          + "indication,signature_note,pharmacy_note,name,status,daw) "
          + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  public final static String insertRating =
      "INSERT into public.ratings (patient,provider,birthday,gender,visit,chart,check_in_info,"
          + "fallin_asleep_rating,fallin_asleep_desc,sleep_during_the_night_rating,"
          + "sleep_during_the_night_desc,waking_up_too_easily_rating,waking_up_too_easily_desc,"
          + "sleeping_too_much_rating,sleeping_too_much_desc,feeling_sad_rating,feeling_sad_desc,"
          + "decreased_appetite_rating,decreased_appetite_desc,increased_appetite_rating,"
          + "increased_appetite_desc,decreased_weight_rating,decreased_weight_desc,"
          + "increased_weight_rating,increased_weight_desc,concentration_decision_making_rating,"
          + "concentration_decision_making_desc,view_of_myself_rating,view_of_myself_desc,"
          + "thoughts_of_death_or_suicide_rating,thoughts_of_death_or_suicide_desc,"
          + "general_interest_rating,general_interest_desc,energy_level_rating,energy_level_desc,"
          + "feeling_slowed_down_rating,feeling_slowed_down_desc,feeling_restless_rating,"
          + "feeling_restless_desc,feeling_nervous_rating,feeling_nervous_desc,"
          + "stop_worrying_rating,stop_worrying_desc,too_worrying_rating,too_worrying_desc,"
          + "trouble_relaxing_rating,trouble_relaxing_desc,psychomotor_rating,psychomotor_desc,"
          + "irritable_rating,irritable_desc,fear_rating,fear_desc) "
          + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
          + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  public final static String getAppointment = "SELECT * from public.appointments where appointmentid = :appointmentid";

  public final static String getMedication = "SELECT * from public.medication where id = :id";

  public final static String getAllPatientIds = "SELECT id from public.patient";


}
