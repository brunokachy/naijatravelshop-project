package com.naijatravelshop;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.RoleType;
import com.naijatravelshop.persistence.model.hotel.HotelCity;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.PortalUserRoleMap;
import com.naijatravelshop.persistence.model.portal.Role;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.hotel.HotelCityRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRoleMapRepository;
import com.naijatravelshop.persistence.repository.portal.RoleRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.web.constants.ProjectConstant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.Optional;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Component
public class AppInitializator {

    private RoleRepository roleRepository;
    private SettingRepository settingRepository;
    private HotelCityRepository hotelCityRepository;
    private PortalUserRepository portalUserRepository;
    private PortalUserRoleMapRepository portalUserRoleMapRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(AppInitializator.class);


    public AppInitializator(RoleRepository roleRepository,
                            SettingRepository settingRepository,
                            HotelCityRepository hotelCityRepository,
                            PortalUserRepository portalUserRepository,
                            PortalUserRoleMapRepository portalUserRoleMapRepository,
                            PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.settingRepository = settingRepository;
        this.hotelCityRepository = hotelCityRepository;
        this.portalUserRepository = portalUserRepository;
        this.portalUserRoleMapRepository = portalUserRoleMapRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void init() {
        log.info("AppInitializator initialization logic ...");
        checkUserRole();
        createFlwCredentials();
        createDotwCredentials();
        // populateHotelCity();
        createCurrencyExchangeRate();
        createSuperAdmin();
    }

    private void checkUserRole() {
        Optional<Role> optionalRole;

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.SUPER_ADMIN);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("Portal Super Admin");
            role.setDisplayName(RoleType.SUPER_ADMIN.getValue());
            role.setName(RoleType.SUPER_ADMIN);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.PORTAL_USER);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("Portal User");
            role.setDisplayName(RoleType.PORTAL_USER.getValue());
            role.setName(RoleType.PORTAL_USER);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.GUEST);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("Guest");
            role.setDisplayName(RoleType.GUEST.getValue());
            role.setName(RoleType.GUEST);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.TICKETING_OFFICER);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("TICKETING OFFICER");
            role.setDisplayName(RoleType.TICKETING_OFFICER.getValue());
            role.setName(RoleType.TICKETING_OFFICER);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.CUSTOMER_SUPPORT);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("CUSTOMER SUPPORT");
            role.setDisplayName(RoleType.CUSTOMER_SUPPORT.getValue());
            role.setName(RoleType.CUSTOMER_SUPPORT);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.HOTEL_CONSULTANT);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("HOTEL CONSULTANT");
            role.setDisplayName(RoleType.HOTEL_CONSULTANT.getValue());
            role.setName(RoleType.HOTEL_CONSULTANT);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.TRAVEL_CONSULTANT);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("TRAVEL CONSULTANT");
            role.setDisplayName(RoleType.TRAVEL_CONSULTANT.getValue());
            role.setName(RoleType.TRAVEL_CONSULTANT);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.VISA_CONSULTANT);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("VISA CONSULTANT");
            role.setDisplayName(RoleType.VISA_CONSULTANT.getValue());
            role.setName(RoleType.VISA_CONSULTANT);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.PRICING_OFFICER);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("PRICING OFFICER");
            role.setDisplayName(RoleType.PRICING_OFFICER.getValue());
            role.setName(RoleType.PRICING_OFFICER);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.FINANCE_OFFICER);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("FINANCE OFFICER");
            role.setDisplayName(RoleType.FINANCE_OFFICER.getValue());
            role.setName(RoleType.FINANCE_OFFICER);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.SUPERVISOR);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("SUPERVISOR");
            role.setDisplayName(RoleType.SUPERVISOR.getValue());
            role.setName(RoleType.SUPERVISOR);
            roleRepository.save(role);
        }
    }

    @Transactional
    void createSuperAdmin() {
        Optional<PortalUser> optionalPortalUser;

        optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus("superadmin@naijatravelshop.com", EntityStatus.ACTIVE);
        if (!optionalPortalUser.isPresent()) {
            PortalUser portalUser = new PortalUser();
            portalUser.setPassword(passwordEncoder.encode("&$dS3ndM#**"));
            portalUser.setFirstName("Super Admin");
            portalUser.setLastName("Super Admin");
            portalUser.setPhoneNumber("08141500042");
            portalUser.setEmail("superadmin@naijatravelshop.com");
            portalUser.setStatus(EntityStatus.ACTIVE);
            portalUserRepository.save(portalUser);

            Optional<Role> optionalRole = roleRepository.findFirstByNameEquals(RoleType.SUPER_ADMIN);
            PortalUserRoleMap portalUserRoleMap = new PortalUserRoleMap();
            portalUserRoleMap.setPortalUser(portalUser);
            portalUserRoleMap.setRole(optionalRole.get());
            portalUserRoleMap.setStatus(EntityStatus.ACTIVE);
            portalUserRoleMapRepository.save(portalUserRoleMap);
        }
    }

    void createDotwCredentials() {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_HOST_URL);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.DOTW_HOST_URL);
            setting.setName(ProjectConstant.DOTW_HOST_URL);
            setting.setValue("https://xmldev.dotwconnect.com/gatewayV4.dotw");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_CUSTOMER_NAME);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.DOTW_CUSTOMER_NAME);
            setting.setName(ProjectConstant.DOTW_CUSTOMER_NAME);
            setting.setValue("NaijaTravelShop LifeStyle Company Limited");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_ID);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.DOTW_LOGIN_ID);
            setting.setName(ProjectConstant.DOTW_LOGIN_ID);
            setting.setValue("NaijaTravelShop");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_PASSWORD);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.DOTW_LOGIN_PASSWORD);
            setting.setName(ProjectConstant.DOTW_LOGIN_PASSWORD);
            setting.setValue("A66E70CF8262E3040EAB0B755BDA247D");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_COMPANY_CODE);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.DOTW_COMPANY_CODE);
            setting.setName(ProjectConstant.DOTW_COMPANY_CODE);
            setting.setValue("1612065");
            settingRepository.save(setting);
        }
    }

    @Transactional
    void createFlwCredentials() {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
            setting.setName(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
            setting.setValue("https://ravesandboxapi.flutterwave.com/flwv3-pug/getpaidx/api/v2/verify");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PUBLIC_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.FLW_PUBLIC_KEY);
            setting.setName(ProjectConstant.FLW_PUBLIC_KEY);
            setting.setValue("FLWPUBK_TEST-8d17767a4a8db582163c16bb16ec4a75-X");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_SECRET_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.FLW_SECRET_KEY);
            setting.setName(ProjectConstant.FLW_SECRET_KEY);
            setting.setValue("FLWSECK_TEST-701c12446da86736e088cc0683802991-X");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.AFFILIATE_SECRET_KEY);
            setting.setName(ProjectConstant.AFFILIATE_SECRET_KEY);
            setting.setValue("DBB049465F3F79176658A7F77C05D8A0");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.AFFILIATE_CODE);
            setting.setName(ProjectConstant.AFFILIATE_CODE);
            setting.setValue("TBAF0000000059");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.AFFILIATE_PUBLIC_KEY);
            setting.setName(ProjectConstant.AFFILIATE_PUBLIC_KEY);
            setting.setValue("D4071DA79A7C79CD9A099A1C36CAEAB6");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.API_BASE_URL);
            setting.setName(ProjectConstant.API_BASE_URL);
            setting.setValue("http://139.162.210.123:8086/v1/");
            settingRepository.save(setting);
        }
    }

    void populateHotelCity() {
        JSONParser parser = new JSONParser();

        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("C:/Users/Bruno/Downloads/hotelcity.json"));

            for (Object o : array) {
                JSONObject city = (JSONObject) o;

                HotelCity hotelCity = new HotelCity();
                hotelCity.setCode((String) city.get("code"));
                hotelCity.setCountryCode((String) city.get("countryCode"));
                hotelCity.setCountryName((String) city.get("countryName"));
                hotelCity.setName((String) city.get("name"));

                hotelCityRepository.save(hotelCity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createCurrencyExchangeRate() {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.CURRENCY_EXCHANGE_RATE);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.CURRENCY_EXCHANGE_RATE);
            setting.setName(ProjectConstant.CURRENCY_EXCHANGE_RATE);
            setting.setValue("365");
            settingRepository.save(setting);
        }
    }


}
