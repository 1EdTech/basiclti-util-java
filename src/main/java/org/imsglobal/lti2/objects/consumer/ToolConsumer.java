package org.imsglobal.lti2.objects.consumer;

import org.imsglobal.lti2.LTI2Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.imsglobal.lti2.objects.BaseJson;

@JsonPropertyOrder({
    "@context",
    "@type",
    "@id"
})
@com.fasterxml.jackson.annotation.JsonPropertyOrder({
    "@context",
    "@type",
    "@id"
})
public class ToolConsumer extends BaseJson {

    @JsonProperty("@context")
    @com.fasterxml.jackson.annotation.JsonProperty("@context")
    private Object _context;
    @JsonProperty("@type")
    @com.fasterxml.jackson.annotation.JsonProperty("@type")
    private String _type;
    @JsonProperty("@id")
    @com.fasterxml.jackson.annotation.JsonProperty("@id")
    private String _id;
    private String lti_version;
    private String guid;
    private ProductInstance product_instance;
    private List<String> capability_offered = new ArrayList<String>();
    private List<ServiceOffered> service_offered = new ArrayList<ServiceOffered>();

    public static final class LtiCapability {
        public static final String BASICLTI_LAUNCH = "basic-lti-launch-request";
        public static final String USER_ID = "User.id";
        public static final String USER_IMAGE = "User.image";
        public static final String COURSE_SECTION_ID = "CourseSection.sourcedId";
        public static final String PERSON_ID = "Person.sourcedId";
        public static final String MEMBERSHIP_ROLE = "Membership.role";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#Context.org
         * A URI describing the organisational properties of the context from which a launch request originates (typically a CourseSection); for example, an ldap:// URI such as
         * ldap://host.com:6666/cid=abc123,ou=dept,dc=plainjoe,dc=org
         * If more than one format of organisational URI is specified, each should be separated with a space.
         */
        public static final String LAUNCH_CONTEXT = "ltiv:Context.org";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.academicSession
         * The text data that is used to describe the academic session for the course offering.
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/courseOffering/defaultCredits/textString
         */
        public static final String CO_ACADEMIC_SESSION = "ltiv:CourseOffering.academicSession";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.credits
         * The default credits set for this Course Offering
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/courseOffering/defaultCredits/textString
         */
        public static String CO_CREDITS = "CourseOffering.credits";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.label
         * A human readable label for the Course Offering
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/courseOffering/label
         */
        public static String CO_LABEL = "CourseOffering.label";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.longDescription
         * A long description of the Course Offering.
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/courseOffering/catalogDescription/longDescription
         */
        public static String CO_LONG_DESCRIPTION = "ltiv:CourseOffering.longDescription";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.shortDescription
         * A short description of the Course Offering.
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/courseOffering/catalogDescription/shortDescription
         */
        public static String CO_SHORT_DESCRIPTION = "CourseOffering.shortDescription";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.sourcedId
         * The LIS identifier for the Course Offering.
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/sourcedId
         */
        public static String CO_SOURCED_ID = "CourseOffering.sourcedId";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseOffering.title
         * The title of the Course Offering.
         * In the LIS Database, this value corresponds to
         * courseOfferingRecord/courseOffering/title
         */
        public static String CO_TITLE = "CourseOffering.title";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.courseNumber
         * The course number, such as "Biology 101". In general, this number is not just a numeric value.
         * In the LIS Database, this value corresponds to
         * courseSectionRecord/courseSection/courseNumber/textString
         */
        public static String CS_COURSE_NUMBER = "ltiv:CourseSection.courseNumber";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.credits
         The default credits set for the Course Section.
         In the LIS Database, this value corresponds to

         courseSectionRecord/courseSection/defaultCredits/textString
         */
        public static String CS_CREDITS = "CourseSection.credits";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.dataSource
         An identifier for the original source system of the CourseSection object.
         In the LIS Database, this value corresponds to

         courseSectionRecord/courseSection/dataSource
         */
        public static String CS_DATA_SOURCE = "CourseSection.dataSource";

        /**
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.dept
         * The department within which the Course Section is offered.
         * In the LIS Database, this value corresponds to
         * courseSectionRecord/courseSection/org[type/textString="Dept"]/orgName/textString
         */
        public static String CS_DEPARTMENT = "CourseSection.dept";

        /**
         * ltiv:CourseSection.enrollControl.allowed
         * http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.enrollControl.allowed
         * A boolean value that specifies whether the Tool Provider can enroll people in the Course Section. The value false indicates that only the source system can enroll people.
         * In the LIS Database, this value corresponds to
         * courseSectionRecord/courseSection/enrollControl/enrollAllowed
         */
        public static String CS_ENROLL_ALLOWED = "";


        /** http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.enrollControll.accept */
        public static String CS_ENROLL_CONTROLL = "ltiv:CourseSection.enrollControll.accept";

        /*
        A boolean value that specifies whether the Course Section is accepting enrollments.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/enrollControl/enrollAccept
        ltiv:CourseSection.label
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.label
        A human readable label for the Course Section.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/label
        ltiv:CourseSection.longDescription
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.longDescription
        A long description of the Course Section.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/catalogDescription/longDescription
        CourseSection.maxNumberofStudents
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.maxNumberofStudents
        The maximum number of students that can be enrolled in the Course Section.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/maxNumberofStudents
        CourseSection.numberofStudents
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.numberofStudents
        The number of students who are enrolled in the Course Section.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/numberofStudents
        CourseSection.shortDescription
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.shortDescription
        A short description of the Course Section.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/catalogDescription/shortDescription
        ltiv:CourseSection.sourceSectionId
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.sourceSectionId
        The identifier for the source Course Section from which the target Course Section was cloned.
        In the LIS Database, this value corresponds to

        createCourseSectionFromCourseSectionRequest/sourcedId
        ltiv:CourseSection.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.sourcedId
        The LIS identifier for the Course Section
        In the LIS Database, this value corresponds to

        courseSection/sourcedId
        CourseSection.timeFrame.begin
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.timeFrame.begin
        The date and time when the Course Section becomes available.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/timeFrame/begin
        CourseSection.timeFrame.end
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.timeFrame.end
        The date and time after which the Course Section is no longer available.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/timeFrame/end
        CourseSection.title
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseSection.title
        The title of the Course Section.
        In the LIS Database, this value corresponds to

        courseSectionRecord/courseSection/title
        ltiv:CourseTemplate.courseNumber
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.courseNumber
        The course number, such as "Biology 101". In general, this number is not just a numeric value.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/courseTemplate/courseNumber/textString
        ltiv:CourseTemplate.credits
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.credits
        The default credits set for this Course Template.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/courseTemplate/defaultCredits/textString
        CourseTemplate.label
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.label
        A human readable label used to help identify the Course Template.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/courseTemplate/label/textString
        ltiv:CourseTemplate.longDescription
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.longDescription
        A long description of the Course Template.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/courseTemplate/catalogDescription/longDescription
        ltiv:CourseTemplate.shortDescription
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.shortDescription
        A short description of the Course Template.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/courseTemplate/catalogDescription/shortDescription
        ltiv:CourseTemplate.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.sourcedId
        The LIS identifier for the Course Template.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/sourcedId
        ltiv:CourseTemplate.title
        http://purl.imsglobal.org/vocab/lti/v2/variable#CourseTemplate.title
        The title of the Course Template.
        In the LIS Database, this value corresponds to

        courseTemplateRecord/courseTemplate/title/textString
        ltiv:Group.email
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.email
        An email address used for posting messages to members of the group.
        In the LIS Database, this value corresponds to

        groupRecord/group/email
        Group.enrollControl.accept
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.enrollControl.accept
        A boolean value that specifies whether the Group is accepting enrollments.
        In the LIS Database, this value corresponds to

        groupRecord/group/enrollControl/enrollAccept
        ltiv:Group.enrollControl.allowed
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.enrollControl.allowed
        A boolean value that specifies whether the Tool Provider can enroll people in the Group. The value false indicates that only the source system can enroll people.
        In the LIS Database, this value corresponds to

        groupRecord/group/enrollControl/enrollAllowed
        ltiv:Group.grouptype
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.grouptype
        A URI that uniquely identifies the type of group. This convention differs from the LIS convention of using a structured object to describe the type of a group. Ideally, the URI should resolve to JSON-LD document that describes the group type. However, any URI that uniquely identifies the group type in accordance with the rules of the grouptype scheme is acceptable.
                ltiv:Group.longDescription
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.longDescription
        A long description of the Group.
        In the LIS Database, this value corresponds to

        groupRecord/group/description/longDescription
        ltiv:Group.parentId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.parentId
        An identifier for the parent group within which the target group is nested.
        In the LIS Database, this value corresponds to

        groupRecord/group/relationship[relation="Parent"]/sourcedId
        ltiv:Group.shortDescription
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.shortDescription
        A short description of the Group.
        In the LIS Database, this value corresponds to

        groupRecord/group/description/shortDescription
        Group.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.sourcedId
        The LIS identifier for the Group.
        In the LIS Database, this value corresponds to

        groupRecord/sourcedId
        ltiv:Group.timeFrame.begin
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.timeFrame.begin
        The date and time when access to Group resources begins.
        In the LIS Database, this value corresponds to

        groupRecord/group/timeframe/begin
        Group.timeFrame.end
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.timeFrame.end
        The date and time when access to Group resources ends.
        In the LIS Database, this value corresponds to

        groupRecord/group/timeframe/end
        ltiv:Group.url
        http://purl.imsglobal.org/vocab/lti/v2/variable#Group.url
        The web address of the Group.
        In the LIS Database, this value corresponds to

        groupRecord/group/url
        LineItem.dataSource
        http://purl.imsglobal.org/vocab/lti/v2/variable#LineItem.dataSource
        An identifier for the original source system of the LineItem record.
        In the LIS Database, this value corresponds to

        lineItemRecord/lineItem/dataSource
        ltiv:LineItem.resultValue.max
        http://purl.imsglobal.org/vocab/lti/v2/variable#LineItem.resultValue.max
        The maximum numeric score that a learner may earn on the assignment associated with this LineItem.
        In the LIS Database, this value corresponds to

        resultValueRecord/resultValue/valueRange/max
                where

        resultValueRecord.sourcedId = lineItemRecord/lineItem/resultValueSourcedId
        ltiv:LineItem.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#LineItem.sourcedId
        The LIS identifier for the LineItem
        In the LIS Database, this value corresponds to

        lineItemRecord/sourcedId
        LineItem.type
        http://purl.imsglobal.org/vocab/lti/v2/variable#LineItem.type
        A URI that uniquely identifies the LineItem type. This convention differs from the LIS convention of using a structured object to describe LineItem types. The URI should resolve to a JSON-LD resource that describes the LineItem type. As a best practice the URI should start with a base URL that identifies the LineItemType vocabulary and end with a relative URL for a type within that vocabulary.
        In the LIS Database, the LineItem type is given by

        lineItemRecord/lineItem/lineItemType
        ltiv:LineItem.type.displayName
        http://purl.imsglobal.org/vocab/lti/v2/variable#LineItem.type.displayName
        The display name for the LineItemType.
        In the LIS Database, this value corresponds to

        lineItemTypeRecord/lineItemType/displayName
        LtiLink.custom.url
        http://purl.imsglobal.org/vocab/lti/v2/variable#LtiLink.custom.url
        The endpoint URL for accessing link-level tool settings.
                Membership.collectionSourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.collectionSourcedId
        The LIS identifier for the organizational unit (Course Section, Group, etc.) to which the Membership pertains.
        In the LIS Database, this value corresponds to

        membershipRecord/membership/collectionSourcedId
        ltiv:Membership.createdTimestamp
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.createdTimestamp
        The date and time when the membership role was created. If the Person has more than one role within the organizational unit, then this value is a comma separated list corresponding to the roles listed by the Membership.role variable.
        In the LIS Database, this value corresponds to

        membershipRecord/membership/member/role/dateTime
        ltiv:Membership.dataSource
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.dataSource
        An identifier for the original source system of the Membership record.
        In the LIS Database, this value corresponds to

        membershipRecord/membership/member/role/dataSource
        ltiv:Membership.personSourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.personSourcedId
        The LIS identifier for the Person associated with the Membership.
        In the LIS Database, this value corresponds to

        membershipRecord/membership/member/personSourcedId
        ltiv:Membership.role
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.role
        A comma separated list of roles that the Person has within the organizational unit.
        In the LIS Database, this value corresponds to

        membershipRecord/membership/member/role/roleType
        ltiv:Membership.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.sourcedId
        The LIS identifier for the Membership.
        In the LIS Database, this value corresponds to

        membershipRecord/sourcedId
        Membership.status
        http://purl.imsglobal.org/vocab/lti/v2/variable#Membership.status
        Indicates if the membership is active or inactive. In accordance with the LIS specification, the value should be either Active or Inactive. If the Person has more than one role within the organizational unit, then this value is a comma separated list, where the values are ordered in correspondence with the roles named by the Membership.role variable.
        In the LIS Database, this value corresponds to

        membershipRecord/membership/member/role/status
        Person.address.country
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.country
        The country within the user's address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="Country"]/instanceValue/text
        ltiv:Person.address.locality
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.locality
        The city, town, or other locality within the user's address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="Locality"]/instanceValue/text
        Person.address.postcode
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.postcode
        The postal code within the user's address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="Postcode"]/instanceValue/text
        ltiv:Person.address.statepr
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.statepr
        The state or province within the user's address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair/[instanceName/text="Statepr"]/instanceValue/text
        ltiv:Person.address.street1
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.street1
        The first line of the user's street address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="NonFieldedStreetAddress1"]/instanceValue /text
        ltiv:Person.address.street2
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.street2
        The second line of the user's street address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]  addressPart /nameValuePair[instanceName/text="NonFieldedStreetAddress2"] /instanceValue/text
        ltiv:Person.address.street3
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.street3
        The third line of the user's street address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="NonFieldedStreetAddress3"] /instanceValue/text
        ltiv:Person.address.street4
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.street4
        The fourth line of the user's street address.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="NonFieldedStreetAddress4"] /instanceValue/text
        Person.address.timezone
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.address.timezone
        The user's time zone.
        In the LIS Database, this value corresponds to

        personRecord/person/address/[addressType/instanceValue/text="Preferred"]addressPart /nameValuePair /[instanceName/text="Timezone"]/instanceValue/text
        ltiv:Person.email.personal
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.email.personal
        The user's personal email address
        In the LIS Database, this value corresponds to

        person/contactinfo[contactinfoType/instanceValue/text="Email_Personal"]/contactinfoValue /text
        ltiv:Person.email.primary
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.email.primary
        The user's primary email address.
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo[contactinfoType/instanceValue/text="Email_Primary"] /contactinfoValue/text
        ltiv:Person.name.family
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.name.family
        The family name of the user.
        In the LIS Database, this value corresponds to

        personRecord/person/name/partName[instanceName/text="Family”]/instanceValue/text
        Person.name.full
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.name.full
        The full name of the user.
        In the LIS Database, this value corresponds to

        personRecord/person/formname/[formnameType/instanceValue/text="Full"] /formattedName/text
        Person.name.given
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.name.given
        The given name of the user.
        In the LIS Database, this value corresponds to

        personRecord/person/name/partName[instanceName/text="Given”]/instanceValue/text
        ltiv:Person.name.middle
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.name.middle
        The middle name of the user.
        In the LIS Database, this value corresponds to

        personRecord/person/name/partName[instanceName/text="Middle”]/instanceValue/text
        Person.name.prefix
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.name.prefix
        The prefix for the user's name, such as Dr., Mr., Ms. etc.
        In the LIS Database, this value corresponds to

        personRecord/person/name/partName[instanceName/text="Prefix”]/instanceValue/text
        ltiv:Person.name.suffix
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.name.suffix
        The suffix for the user's name, such as Jr., II, etc.
        In the LIS Database, this value corresponds to

        personRecord/person/name/partName[instanceName/text="Suffix”]/instanceValue/text
        ltiv:Person.phone.home
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.phone.home
        The user's home phone number
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo [contactinfoType/instanceValue/text="Telephone_Home"]/contactinfoValue /text
        ltiv:Person.phone.mobile
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.phone.mobile
        The user's mobile phone number
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo[contactinfoType/instanceValue/text="Mobile"] /contactInfoValue/text
        Person.phone.primary
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.phone.primary
        The user's primary phone number
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo [contactinfoType/instanceValue/text="Telephone_Primary"]/contactinfoValue /text
        ltiv:Person.phone.work
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.phone.work
        The user's work phone number.
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo [contactinfoType/instanceValue/text="Telephone_Work"]/contactinfoValue /text
        Person.sms
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.sms
        The number at which the user prefers to receive SMS text messages.
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo[contactinfoType/instanceValue/text="SMS"]  /contactinfoValue/text
        ltiv:Person.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.sourcedId
        The LIS identifier for the user.
        In the LIS Database, this value corresponds to personRecord/sourcedId

        Person.webaddress
        http://purl.imsglobal.org/vocab/lti/v2/variable#Person.webaddress
        The user's web address. This could be a facebook address, a blog, or any other web address linked to the user. The value should be a URL.
        In the LIS Database, this value corresponds to

        personRecord/person/contactinfo[contactinfoType/instanceValue/text="Web-Address"] /contactinfoValue/text
        ltiv:ResourceLink.description
        http://purl.imsglobal.org/vocab/lti/v2/variable#ResourceLink.description
        A plain text description of the link’s destination, suitable for display alongside the link.
        ltiv:ResourceLink.title
        http://purl.imsglobal.org/vocab/lti/v2/variable#ResourceLink.title
        A plain text title for the resource.
        Result.autocreate
        http://purl.imsglobal.org/vocab/lti/v2/capability#Result.autocreate
        Result.comment
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.comment
        A comment associated with the outcome which may be made visible to the student.
        ltiv:Result.createdTimestamp
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.createdTimestamp
        The date and time when the Result was created.
        In the LIS Database, this value corresponds to

        ltiv:Result.dataSource
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.dataSource
        An identifier for the original source system of the Result record.
        In the LIS Database, this value corresponds to

        resultRecord/result/dataSource
        Result.resultScore
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.resultScore
        The score that the learner earned on the assignment or activity to which this Result pertains.
        In the LIS Database, this value corresponds to

        resultRecord/result/resultScore/textString
        ltiv:Result.sourcedId
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.sourcedId
        The LIS identifier for the Result resource.
        In the LIS Database, this value corresponds to

        ltiv:Result.status
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.status
        A URI for the status of the Result. As a best practice, the URI should resolve to a JSON-LD description of the status value or a term in a VDEX file. The vocabulary for Result status values is extensible. The set of standard values includes:
        http://www.imsglobal.org/lis/omsv1p0/statusofresultvocabularyv1p0#Unmoderated
        http://www.imsglobal.org/lis/omsv1p0/statusofresultvocabularyv1p0#Tobemoderated
        http://www.imsglobal.org/lis/omsv1p0/statusofresultvocabularyv1p0#Pending
        http://www.imsglobal.org/lis/omsv1p0/statusofresultvocabularyv1p0#Completed
        Result.url
        http://purl.imsglobal.org/vocab/lti/v2/variable#Result.url
        The URL of the Result resource. Client applications may issue an HTTP request to read, update or delete the resource at this URL.
                ltiv:ToolProxy.custom.url
        http://purl.imsglobal.org/vocab/lti/v2/variable#ToolProxy.custom.url
        The endpoint URL for accessing system-wide tool settings.
                ToolProxyBinding.custom.url
        http://purl.imsglobal.org/vocab/lti/v2/variable#ToolProxyBinding.custom.url
        The endpoint URL for accessing context-level tool settings.
                User.id
        http://purl.imsglobal.org/vocab/lti/v2/variable#User.id
        Corresponds to the user_id launch parameterfrom the LaunchMixin class. This is the local identifier for the user within the Tool Consumer system.
                User.image
        http://purl.imsglobal.org/vocab/lti/v2/variable#User.image
        The URL for an image of the user suitable for use as a profile picture or avatar.
                User.org
        http://purl.imsglobal.org/vocab/lti/v2/variable#User.org
        A URI describing the user's organisational properties; for example, an ldap:// URI such as
        ldap://host.com:6666/uid=user,ou=people,dc=example,dc=com
                . If more than one format of organisational URI is specified, each should be separated with a space.
        User.username
        */



    }

    public static String TYPE = "ToolConsumerProfile";
    public static String TC_PROFILE_CONTEXT = "http://purl.imsglobal.org/ctx/lti/v2/ToolConsumerProfile";

    public ToolConsumer(){}

    // Constructor
    public ToolConsumer(String guid, String ltiVersion, String tcp, LTI2Config cnf) {
        this._context = TC_PROFILE_CONTEXT;
        this._type = TYPE;
        this.lti_version = ltiVersion; // "LTI-2p0";
        this.guid = guid;
        this.product_instance = new ProductInstance(cnf);
    }

    public Object get_context() {
        return _context;
    }

    public void set_context(List<Object> _context) {
        this._context = _context;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLti_version() {
        return lti_version;
    }

    public void setLti_version(String lti_version) {
        this.lti_version = lti_version;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public ProductInstance getProduct_instance() {
        return product_instance;
    }

    public void setProduct_instance(ProductInstance product_instance) {
        this.product_instance = product_instance;
    }

    public List<String> getCapability_offered() {
        return capability_offered;
    }

    public void setCapability_offered(List<String> capability_offered) {
        this.capability_offered = capability_offered;
    }

    public List<ServiceOffered> getService_offered() {
        return service_offered;
    }

    public void setService_offered(List<ServiceOffered> service_offered) {
        this.service_offered = service_offered;
    }

    // Convienence method
    public void addCapabilites(List<String> capabilities) {
        this.capability_offered.addAll(capabilities);
    }
    
    public void addServiceOffered(ServiceOffered service) {
        this.service_offered.add(service);
    }
    
    public void addAllServiceOffered(List<ServiceOffered> service) {
        this.service_offered.addAll(service);
    }

}
